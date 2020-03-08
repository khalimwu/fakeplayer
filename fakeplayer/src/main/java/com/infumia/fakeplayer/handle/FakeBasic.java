package com.infumia.fakeplayer.handle;

import com.infumia.fakeplayer.api.Fake;
import com.infumia.fakeplayer.api.FakeCreated;
import com.infumia.fakeplayer.api.INPC;
import com.infumia.fakeplayer.api.MockFakeCreated;
import io.github.portlek.versionmatched.VersionMatched;
import java.util.Optional;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FakeBasic implements Fake {

    private static final FakeCreated FAKE_CREATED = new VersionMatched<>(
        new MockFakeCreated()
    ).of().instance();

    @NotNull
    private final String name;

    @NotNull
    private final Location spawnpoint;

    @Nullable
    private INPC npc;

    public FakeBasic(@NotNull final String name, @NotNull final Location spawnpoint) {
        this.name = name;
        this.spawnpoint = spawnpoint;
    }

    @NotNull
    @Override
    public String getName() {
        return this.name;
    }

    @NotNull
    @Override
    public Location getSpawnPoint() {
        return this.spawnpoint;
    }

    @Override
    public void spawn() {
        Optional.ofNullable(this.spawnpoint.getWorld()).ifPresent(world -> {
            this.npc = FakeBasic.FAKE_CREATED.create(this.name, world);
            this.npc.spawn(this.spawnpoint);
        });
    }

}
