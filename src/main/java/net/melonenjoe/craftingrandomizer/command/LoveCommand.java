package net.melonenjoe.craftingrandomizer.command;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class LoveCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Dieser Befehl kann nur von Spielern verwendet werden.");
            return true;
        }

        Player targetPlayer;

        // Überprüfe, ob ein Spielername angegeben wurde
        if (args.length > 0) {
            targetPlayer = sender.getServer().getPlayer(args[0]);

            // Überprüfe, ob der angegebene Spieler online ist
            if (targetPlayer == null) {
                sender.sendMessage(ChatColor.RED + "Dieser Spieler ist nicht online!");
                return true;
            }

        } else {

            return false;

        }

        if (((Player) sender).getUniqueId() != targetPlayer.getUniqueId()) {
            targetPlayer.sendMessage("");
            targetPlayer.sendMessage("§4§l ❤❤❤");
            targetPlayer.sendMessage("");
            targetPlayer.sendMessage("§c§l  Ein Spieler möchte dir sagen das er dich mag!");
            targetPlayer.sendMessage("§8  ● §eSpieler der dich mag§7: " + sender.getName());
            targetPlayer.sendMessage("");
            targetPlayer.sendMessage("§4§l ❤❤❤");
            targetPlayer.sendMessage("");

            for (int d = 0; d <= 90; d += 1) {

                Location location = targetPlayer.getLocation();

                location.add(0, 1, 0);

                Location particleLoc = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ());
                particleLoc.setX(location.getX() + Math.cos(d) * 1);
                particleLoc.setZ(location.getZ() + Math.sin(d) * 1);
                targetPlayer.getWorld().spawnParticle(Particle.HEART, particleLoc, 1);
            }

        } else if (((Player) sender).getUniqueId() == targetPlayer.getUniqueId()) {

            sender.sendMessage("§cEs ist gut sich selbst zu mögen!");

        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            // Tab-Completion für den Spielernamen
            for (Player player : sender.getServer().getOnlinePlayers()) {
                completions.add(player.getName());
            }
        }

        // Filtere die Vorschläge basierend auf dem bisher eingegebenen Text
        return StringUtil.copyPartialMatches(args[args.length - 1], completions, new ArrayList<>());
    }
}
