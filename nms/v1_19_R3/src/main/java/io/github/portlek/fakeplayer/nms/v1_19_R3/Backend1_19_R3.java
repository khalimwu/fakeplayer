package io.github.portlek.fakeplayer.nms.v1_19_R3;

import io.github.portlek.fakeplayer.api.AiBackend;
import io.github.portlek.fakeplayer.api.AiPlayer;
import org.jetbrains.annotations.NotNull;

public final class Backend1_19_R3 implements AiBackend {

  @NotNull
  @Override
  public AiPlayer wrap(@NotNull final AiPlayer ai) {
    return new AiPlayerNms(ai);
  }
}
