package io.github.portlek.fakeplayer;

import io.github.portlek.fakeplayer.api.AiBackend;
import io.github.portlek.fakeplayer.api.AiPlayer;
import io.github.portlek.fakeplayer.api.AiPlayerCoordinator;
import io.github.portlek.fakeplayer.api.FakePlayerConfig;
import io.github.portlek.fakeplayer.nms.v1_19_R3.Backend1_19_R3;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import tr.com.infumia.versionmatched.VersionMatched;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class FakePlayerPlugin extends JavaPlugin {

  AiBackend backend = new VersionMatched<>(
    Backend1_19_R3.class
  )
    .of()
    .create()
    .orElseThrow(() -> new IllegalStateException("Something went wrong when creating the backend nms class!"));

  @Override
  public void onLoad() {
    this.reloadFiles();
  }

  @Override
  public void onDisable() {
  }

  @Override
  public void onEnable() {
    saveDefaultConfig();

    AiPlayerCoordinator.backend(this.backend);
    Objects.requireNonNull(this.getCommand("fakeplayer"), "fakeplayer")
      .setExecutor(new FakePlayerCommand(this));

    FileConfiguration config = getConfig();
    List<String> spawnsAtStart = (List<String>) config.get("spawnAtStart");

    for (String name : spawnsAtStart)
    {
      Location location = new Location(Bukkit.getServer().getWorld("world"), 0, 0, 0,0,0);
      UUID uuid = UUID.randomUUID();
      Bukkit.getLogger().info(String.format("Creating player %s with UUID %s", name, uuid));
      AiPlayer newPlayer = AiPlayer.create(name, uuid, location);
      newPlayer.connect();
    }
  }

  @SneakyThrows
  public void reloadFiles() {
    FakePlayerConfig.init(this.getDataFolder().toPath());
  }
}
