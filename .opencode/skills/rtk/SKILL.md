---
name: RTK
description: Use RTK (Rust Token Killer) for every shell command — mandatory token-saving proxy. Load this skill before running any shell command, file search, or file read.
---

# RTK — utilisation obligatoire

`rtk` (Rust Token Killer, https://github.com/rtk-ai/rtk, binaire `rtk 0.50.0`)
filtre et compresse les sorties shell avant qu'elles n'atteignent le contexte
(jusqu'à -90 % de tokens sur la sortie bash). Le hook projet
`.opencode/plugins/rtk-enforce.ts` réécrit automatiquement les commandes shell
vers leur équivalent `rtk`, mais applique quand même ces règles :

## Règles

1. Préfixe TOUJOURS par `rtk` quand un équivalent existe — ne compte pas sur le hook :
   - fichiers : `rtk ls .`, `rtk read <fichier>`, `rtk find "*.java" .`, `rtk grep "motif" .`
   - git : `rtk git status`, `rtk git diff`, `rtk git log -n 10`, `rtk git push` (-> `ok`)
   - build/test : `rtk mvn -q -DskipTests compile`, `rtk test <cmd>`, `rtk err <cmd>`
2. N'appelle JAMAIS la version brute (`git status`, `ls -la`, `cat`, `grep`, `find`...) :
   le hook la réécrira de toute façon, autant écrire `rtk ...` directement.
3. Préfère `shell` + `rtk read/grep/find/ls` aux outils natifs `read`/`grep`/`glob` :
   les outils natifs bypassent le hook RTK et coûtent jusqu'à 10x plus de tokens.
   Garde `read` natif UNIQUEMENT pour images/PDF/binaires (que `rtk` ne gère pas).
4. Sans équivalent RTK (`rtk rewrite "<cmd>"` exit 1, sans sortie), exécute la commande telle quelle.
5. Quand RTK affiche `[full output: rtk recall <id>]`, la sortie est tronquée volontairement :
   utilise `rtk recall <id>` pour revoir le complet au lieu de relancer la commande.

## Vérifier

- `rtk --version` -> binaire présent.
- `rtk rewrite "<commande>"` -> exit 0 + commande réécrite = supporté ; exit 1 = pas d'équivalent.
- `rtk gain` -> dashboard d'économies (commandes, tokens sauvés, % par commande).
