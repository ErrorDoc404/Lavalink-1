package dev.arbjerg.lavalink.protocol

import com.fasterxml.jackson.annotation.JsonValue
import java.util.*

data class Players(
    @JsonValue
    val players: List<Player>
)

data class Player(
    val guildId: String,
    val track: Track?,
    val volume: Int,
    val paused: Boolean,
    val voice: VoiceState,
    val filters: Filters?
)

data class Track(
    val encoded: String,
    val track: String,
    val info: TrackInfo
)

data class TrackInfo(
    val identifier: String,
    val isSeekable: Boolean,
    val author: String,
    val length: Long,
    val isStream: Boolean,
    val position: Long,
    val title: String,
    val uri: String,
    val sourceName: String
)

data class VoiceState(
    val token: String,
    val endpoint: String,
    val sessionId: String,
    val connected: Boolean,
    val ping: Long
)

data class PlayerState(
    val time: Long,
    val position: Long,
    val connected: Boolean,
    val ping: Long
)

data class PlayerUpdate(
    val encodedTrack: Omissible<String?> = Omissible.omitted(),
    val identifier: Omissible<String> = Omissible.omitted(),
    val position: Omissible<Long> = Omissible.omitted(),
    val endTime: Omissible<Long> = Omissible.omitted(),
    val volume: Omissible<Int> = Omissible.omitted(),
    val paused: Omissible<Boolean> = Omissible.omitted(),
    val filters: Optional<Filters> = Optional.empty(),
    val voice: Optional<VoiceState> = Optional.empty()
)