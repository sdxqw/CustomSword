package org.xnotro.customsword

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.event.Listener
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin

@Suppress("DEPRECATION")
class Main : JavaPlugin(), CommandExecutor, Listener {

    var pluginPrefix = "[CustomSword]"

    // Enable Plugin
    override fun onEnable() {
        Bukkit.getConsoleSender().sendMessage(pluginPrefix + " Loading " + description.name)
        Bukkit.getPluginManager().registerEvents(this, this)
        getCommand("customsword")!!.setExecutor(this)
    }

    // onCommand Function (this time in main lol)
    override fun onCommand(sender: CommandSender, cmd: Command, lable: String, args: Array<String>): Boolean {

        // If you type customsword in console start that
        if (cmd.equals("customsword")) {
            if (sender !is Player) {
                sender.sendMessage("You cant use this command in console")
                return true
            }
        }

        // value for player
        val p = sender as Player

        // if you type /customsword it start this
        if (args.isEmpty()) {

            // define the item
            val customSword = ItemStack(Material.GOLDEN_SWORD)

            // get item meta
            val meta = customSword.itemMeta

            // modify item meta things
            meta.setDisplayName("§aSuper §eMega §cSword")
            meta.addEnchant(Enchantment.DAMAGE_ALL, 25, true)

            // modify item meta data with this new cool things
            customSword.itemMeta = meta

            // give the item to player
            p.inventory.addItem(customSword)

            // plz wllp waht thta??
            p.sendMessage("[CustomSword] > Take your cool mega op sword :D")

            // if you use /customsword something
        } else {
            p.sendMessage("[CustomSword] > This action isn't supported sowwy low budget plugin")
        }
        return true
    }
}