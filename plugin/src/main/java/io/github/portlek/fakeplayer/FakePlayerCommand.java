package io.github.portlek.fakeplayer;

import io.github.portlek.fakeplayer.api.AiPlayer;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class FakePlayerCommand implements TabExecutor {

  FakePlayerPlugin plugin;

  @Override
  public boolean onCommand(
    @NotNull final CommandSender sender,
    @NotNull final Command command,
    @NotNull final String label,
    @NotNull final String[] args
  ) {
    if (args.length == 0) {
      Bukkit.getLogger().info("No args, ignoring command");
      return true;
    }
    switch (args[0]) {
      case "reload" -> {
        Bukkit.getScheduler().runTaskAsynchronously(this.plugin, () -> {
          this.plugin.reloadFiles();
          // @todo #1:5m Make '&aReload complete.' customizable.
          Bukkit.getLogger().info("&aReload complete.");
        });
      }
      case "create" -> {
        if (args.length < 1)
        {
          Bukkit.getLogger().info("&aNeed 1 arg for this \"<Name>\"");
          return true;
        }
        Location location = new Location(Bukkit.getServer().getWorld("world"), 0, 0, 0,0,0);
        UUID uuid = UUID.randomUUID();
        String name = args[1];
        Bukkit.getLogger().info(String.format("Creating player %s with UUID %s", name, uuid));
        AiPlayer newPlayer = AiPlayer.create(name, uuid, location);
        newPlayer.connect();
      }
      default -> {
        Bukkit.getLogger().info("Unprocessed. Ignoring command");
      }
    }
    return true;
  }

  @NotNull
  @Override
  public List<String> onTabComplete(
    @NotNull final CommandSender sender,
    @NotNull final Command command,
    @NotNull final String label,
    @NotNull final String[] args
  ) {
    return Collections.emptyList();
  }
}
