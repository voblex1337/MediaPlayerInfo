package dev.redstones.mediaplayerinfo.impl.win

import dev.redstones.mediaplayerinfo.IMediaSession
import dev.redstones.mediaplayerinfo.MediaInfo

class WindowsMediaSession(
    override val media: MediaInfo,
    override val owner: String,
    private val index: Int
) : IMediaSession {

    /**
     * The session's position at the instant of this call, in milliseconds, walked forward from
     * the last timeline update the app pushed while it is playing - the millisecond the timeline
     * carries, not the whole-second timestamp Windows publishes. Packed with the playback state
     * as `position shl 1 or (playing ? 1 : 0)`, or -1 when the session is no longer listed.
     *
     * This read touches the timeline and the playback state only - no media properties, no
     * artwork - so it is cheap enough to ask several dozen times a second, which the full
     * session listing with its artwork is not.
     */
    external fun getLiveState(): Long

    external override fun play()
    external override fun pause()
    external override fun playPause()
    external override fun stop()
    external override fun next()
    external override fun previous()

}
