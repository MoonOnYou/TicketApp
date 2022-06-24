package com.codesample.ticketapp.ui.video

import com.codesample.ticketapp.R
import com.codesample.ticketapp.base.BaseActivity
import com.codesample.ticketapp.constants.IntentKey
import com.codesample.ticketapp.databinding.ActivityVideoBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import org.koin.android.ext.android.inject

class VideoActivity : BaseActivity<ActivityVideoBinding, VideoViewModel>() {
    private val mViewModel : VideoViewModel by inject()

    override fun getLayoutId(): Int {
        return R.layout.activity_video
    }

    override fun onCreated() {
        getData()

    }

    private fun getData() {
        mViewModel.videoModel.value = intent.getParcelableExtra(IntentKey.VIDEO)
        mViewDataBinding.youtubePlayerView?.let {
            mViewDataBinding.lifecycleOwner?.lifecycle?.addObserver(it)
            it.addYouTubePlayerListener(youtubeListener)
        }
        mViewDataBinding.textViewName.text = mViewModel.videoModel.value?.tvNameMain
        mViewDataBinding.textViewViewCont.text = "${mViewModel.videoModel.value?.tvViewCount}명이 이글을 봤어요"
    }

    // YouTubePlayerListener
    private val youtubeListener = object : YouTubePlayerListener {
        override fun onApiChange(youTubePlayer: YouTubePlayer) {}
        override fun onCurrentSecond(youTubePlayer: YouTubePlayer, second: Float) {}
        override fun onError(youTubePlayer: YouTubePlayer, error: PlayerConstants.PlayerError) {}
        override fun onStateChange(
            youTubePlayer: YouTubePlayer,
            state: PlayerConstants.PlayerState
        ) {
            if (state == PlayerConstants.PlayerState.PLAYING) {
            }
        }

        override fun onVideoDuration(youTubePlayer: YouTubePlayer, duration: Float) {
        }
        override fun onVideoId(youTubePlayer: YouTubePlayer, videoId: String) {}
        override fun onVideoLoadedFraction(youTubePlayer: YouTubePlayer, loadedFraction: Float) {}
        override fun onPlaybackQualityChange(
            youTubePlayer: YouTubePlayer,
            playbackQuality: PlayerConstants.PlaybackQuality
        ) {
        }

        override fun onPlaybackRateChange(
            youTubePlayer: YouTubePlayer,
            playbackRate: PlayerConstants.PlaybackRate
        ) {
        }

        override fun onReady(youTubePlayer: YouTubePlayer) {
            youTubePlayer.loadVideo(mViewModel.videoModel.value?.tvVideoId ?: "", 0f)
        }
    }
}