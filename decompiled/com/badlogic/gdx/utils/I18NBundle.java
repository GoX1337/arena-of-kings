/*
 * Decompiled with CFR 0.152.
 */
package com.badlogic.gdx.utils;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.PropertiesUtils;
import com.badlogic.gdx.utils.StreamUtils;
import com.badlogic.gdx.utils.StringBuilder;
import com.badlogic.gdx.utils.TextFormatter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;

public class I18NBundle {
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final Locale ROOT_LOCALE = new Locale("", "", "");
    private static boolean simpleFormatter = false;
    private static boolean exceptionOnMissingKey = true;
    private I18NBundle parent;
    private Locale locale;
    private ObjectMap<String, String> properties;
    private TextFormatter formatter;

    public static boolean getSimpleFormatter() {
        return simpleFormatter;
    }

    public static void setSimpleFormatter(boolean bl2) {
        simpleFormatter = bl2;
    }

    public static boolean getExceptionOnMissingKey() {
        return exceptionOnMissingKey;
    }

    public static void setExceptionOnMissingKey(boolean bl2) {
        exceptionOnMissingKey = bl2;
    }

    public static I18NBundle createBundle(FileHandle fileHandle) {
        return I18NBundle.createBundleImpl(fileHandle, Locale.getDefault(), DEFAULT_ENCODING);
    }

    public static I18NBundle createBundle(FileHandle fileHandle, Locale locale) {
        return I18NBundle.createBundleImpl(fileHandle, locale, DEFAULT_ENCODING);
    }

    public static I18NBundle createBundle(FileHandle fileHandle, String string) {
        return I18NBundle.createBundleImpl(fileHandle, Locale.getDefault(), string);
    }

    public static I18NBundle createBundle(FileHandle fileHandle, Locale locale, String string) {
        return I18NBundle.createBundleImpl(fileHandle, locale, string);
    }

    private static I18NBundle createBundleImpl(FileHandle fileHandle, Locale locale, String string) {
        if (fileHandle == null || locale == null || string == null) {
            throw new NullPointerException();
        }
        I18NBundle i18NBundle = null;
        I18NBundle i18NBundle2 = null;
        Locale locale2 = locale;
        do {
            List<Locale> list;
            if ((i18NBundle = I18NBundle.loadBundleChain(fileHandle, string, list = I18NBundle.getCandidateLocales(locale2), 0, i18NBundle2)) == null) continue;
            Locale locale3 = i18NBundle.getLocale();
            boolean bl2 = locale3.equals(ROOT_LOCALE);
            if (!bl2 || locale3.equals(locale) || list.size() == 1 && locale3.equals(list.get(0))) break;
            if (!bl2 || i18NBundle2 != null) continue;
            i18NBundle2 = i18NBundle;
        } while ((locale2 = I18NBundle.getFallbackLocale(locale2)) != null);
        if (i18NBundle == null) {
            if (i18NBundle2 == null) {
                throw new MissingResourceException("Can't find bundle for base file handle " + fileHandle.path() + ", locale " + locale, fileHandle + "_" + locale, "");
            }
            i18NBundle = i18NBundle2;
        }
        return i18NBundle;
    }

    private static List<Locale> getCandidateLocales(Locale locale) {
        String string = locale.getLanguage();
        String string2 = locale.getCountry();
        String string3 = locale.getVariant();
        ArrayList<Locale> arrayList = new ArrayList<Locale>(4);
        if (string3.length() > 0) {
            arrayList.add(locale);
        }
        if (string2.length() > 0) {
            arrayList.add(arrayList.isEmpty() ? locale : new Locale(string, string2));
        }
        if (string.length() > 0) {
            arrayList.add(arrayList.isEmpty() ? locale : new Locale(string));
        }
        arrayList.add(ROOT_LOCALE);
        return arrayList;
    }

    private static Locale getFallbackLocale(Locale locale) {
        Locale locale2 = Locale.getDefault();
        return locale.equals(locale2) ? null : locale2;
    }

    private static I18NBundle loadBundleChain(FileHandle fileHandle, String string, List<Locale> list, int n2, I18NBundle i18NBundle) {
        Locale locale = list.get(n2);
        I18NBundle i18NBundle2 = null;
        if (n2 != list.size() - 1) {
            i18NBundle2 = I18NBundle.loadBundleChain(fileHandle, string, list, n2 + 1, i18NBundle);
        } else if (i18NBundle != null && locale.equals(ROOT_LOCALE)) {
            return i18NBundle;
        }
        I18NBundle i18NBundle3 = I18NBundle.loadBundle(fileHandle, string, locale);
        if (i18NBundle3 != null) {
            i18NBundle3.parent = i18NBundle2;
            return i18NBundle3;
        }
        return i18NBundle2;
    }

    private static I18NBundle loadBundle(FileHandle fileHandle, String string, Locale locale) {
        I18NBundle i18NBundle = null;
        Reader reader = null;
        try {
            FileHandle fileHandle2 = I18NBundle.toFileHandle(fileHandle, locale);
            if (I18NBundle.checkFileExistence(fileHandle2)) {
                i18NBundle = new I18NBundle();
                reader = fileHandle2.reader(string);
                i18NBundle.load(reader);
            }
        }
        catch (IOException iOException) {
            throw new GdxRuntimeException(iOException);
        }
        finally {
            StreamUtils.closeQuietly(reader);
        }
        if (i18NBundle != null) {
            i18NBundle.setLocale(locale);
        }
        return i18NBundle;
    }

    private static boolean checkFileExistence(FileHandle fileHandle) {
        try {
            fileHandle.read().close();
            return true;
        }
        catch (Exception exception) {
            return false;
        }
    }

    protected void load(Reader reader) {
        this.properties = new ObjectMap();
        PropertiesUtils.load(this.properties, reader);
    }

    private static FileHandle toFileHandle(FileHandle fileHandle, Locale locale) {
        StringBuilder stringBuilder = new StringBuilder(fileHandle.name());
        if (!locale.equals(ROOT_LOCALE)) {
            String string = locale.getLanguage();
            String string2 = locale.getCountry();
            String string3 = locale.getVariant();
            boolean bl2 = "".equals(string);
            boolean bl3 = "".equals(string2);
            boolean bl4 = "".equals(string3);
            if (!(bl2 && bl3 && bl4)) {
                stringBuilder.append('_');
                if (!bl4) {
                    stringBuilder.append(string).append('_').append(string2).append('_').append(string3);
                } else if (!bl3) {
                    stringBuilder.append(string).append('_').append(string2);
                } else {
                    stringBuilder.append(string);
                }
            }
        }
        return fileHandle.sibling(stringBuilder.append(".properties").toString());
    }

    public Locale getLocale() {
        return this.locale;
    }

    private void setLocale(Locale locale) {
        this.locale = locale;
        this.formatter = new TextFormatter(locale, !simpleFormatter);
    }

    public String get(String string) {
        String string2 = this.properties.get(string);
        if (string2 == null) {
            if (this.parent != null) {
                string2 = this.parent.get(string);
            }
            if (string2 == null) {
                if (exceptionOnMissingKey) {
                    throw new MissingResourceException("Can't find bundle key " + string, this.getClass().getName(), string);
                }
                return "???" + string + "???";
            }
        }
        return string2;
    }

    public String format(String string, Object ... objectArray) {
        return this.formatter.format(this.get(string), objectArray);
    }

    public void debug(String string) {
        ObjectMap.Keys<String> keys = this.properties.keys();
        if (keys == null) {
            return;
        }
        for (String string2 : keys) {
            this.properties.put(string2, string);
        }
    }
}

