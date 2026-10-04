import { Plugin } from "@opencode/plugin"
import { execFile } from "node:child_process"
import { promisify } from "node:util"

const execFileAsync = promisify(execFile)

// RTK (Rust Token Killer) — hook projet qui force l'utilisation de RTK.
// 1. `shell.create.before` : réécrit TOUTE commande shell vers son équivalent
//    `rtk ...` via `rtk rewrite` (source unique de vérité, cf. registre Rust).
//    Sans équivalent (exit 1), la commande passe inchangée.
// 2. `tool.execute.before` : rappel non-bloquant quand un outil natif
//    read/grep/glob est utilisé alors que `rtk read/grep/find` via shell
//    coûte jusqu'à 10x moins de tokens (les outils natifs bypassent le hook).
// Voir le skill `rtk` (.opencode/skills/rtk/SKILL.md) pour les règles agent.

async function rtkAvailable(): Promise<boolean> {
  try {
    await execFileAsync("rtk", ["--version"], { timeout: 5000 })
    return true
  } catch {
    return false
  }
}

async function rewriteWithRtk(command: string): Promise<string | null> {
  try {
    const { stdout } = await execFileAsync("rtk", ["rewrite", command], { timeout: 5000 })
    const rewritten = stdout.trim()
    if (rewritten && rewritten !== command) return rewritten
    return null
  } catch {
    return null
  }
}

export default Plugin.define({
  id: "rtk-enforce",
  async setup(ctx) {
    if (!(await rtkAvailable())) {
      console.warn("[rtk-enforce] binaire `rtk` introuvable dans le PATH — plugin désactivé")
      return
    }

    await ctx.shell.hook("create.before", async (event) => {
      if (!event.command || event.command.startsWith("rtk ")) return
      const rewritten = await rewriteWithRtk(event.command)
      if (rewritten) event.command = rewritten
    })

    await ctx.tool.hook("execute.before", (event) => {
      const tool = String(event.tool ?? "").toLowerCase()
      if (tool === "read" || tool === "grep" || tool === "glob") {
        console.warn(
          `[rtk-enforce] outil natif "${tool}" — préfère \`rtk read\` / \`rtk grep\` / \`rtk find\` via shell (skill rtk).`
        )
      }
    })
  },
})
