/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.spi.FileSystemProvider;
import java.util.ServiceLoader;

public class bmc
extends blg<Path> {
    private static final boolean a;

    public bmc() {
        super(Path.class);
    }

    @Override
    public Path a(bdc bdc2, bfs bfs2) {
        URI uRI;
        if (!bdc2.boolean_a(bdf.h)) {
            return (Path)bfs2.a(Path.class, bdc2);
        }
        String string = bdc2.java_lang_String_e();
        if (string.indexOf(58) < 0) {
            return Paths.get(string, new String[0]);
        }
        if (a && string.length() >= 2 && Character.isLetter(string.charAt(0)) && string.charAt(1) == ':') {
            return Paths.get(string, new String[0]);
        }
        try {
            uRI = new URI(string);
        }
        catch (URISyntaxException uRISyntaxException) {
            return (Path)bfs2.a(this.a(), (Object)string, uRISyntaxException);
        }
        try {
            return Paths.get(uRI);
        }
        catch (FileSystemNotFoundException fileSystemNotFoundException) {
            try {
                String string2 = uRI.getScheme();
                for (FileSystemProvider fileSystemProvider : ServiceLoader.load(FileSystemProvider.class)) {
                    if (!fileSystemProvider.getScheme().equalsIgnoreCase(string2)) continue;
                    return fileSystemProvider.getPath(uRI);
                }
                return (Path)bfs2.a(this.a(), (Object)string, fileSystemNotFoundException);
            }
            catch (Throwable throwable) {
                throwable.addSuppressed(fileSystemNotFoundException);
                return (Path)bfs2.a(this.a(), (Object)string, throwable);
            }
        }
        catch (Throwable throwable) {
            return (Path)bfs2.a(this.a(), (Object)string, throwable);
        }
    }

    static {
        boolean bl2 = false;
        for (File file : File.listRoots()) {
            String string = file.getPath();
            if (string.length() < 2 || !Character.isLetter(string.charAt(0)) || string.charAt(1) != ':') continue;
            bl2 = true;
            break;
        }
        a = bl2;
    }
}

