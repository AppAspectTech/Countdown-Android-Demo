package com.appaspect.countdown.notify.model


import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.time.Duration
import android.os.CountDownTimer
import androidx.lifecycle.ViewModel
import com.appaspect.countdown.notify.AppConstant

class TimerViewModel : ViewModel() {

    private val _viewState = MutableStateFlow(TimerModel())
    val viewState: StateFlow<TimerModel> = _viewState

    private var countDown: CountDownTimer? = null

    init {
        _viewState.value = TimerModel()
    }

    private fun startTime(duration: Duration) {
        countDown = object : CountDownTimer(duration.toMillis(), 10) {
            override fun onTick(seconds: Long) {
                _viewState.value = TimerModel(
                    timeDuration = Duration.ofMillis(seconds),
                    remainingTime = seconds,
                    status = Status.RUNNING,
                    toggle = ButtonState.PAUSE
                )
            }

            override fun onFinish() {
                _viewState.value = _viewState.value.copy(
                    timeDuration = Duration.ZERO,
                    status = Status.FINISHED,
                    toggle = ButtonState.START
                )
            }
        }
        countDown?.start()
    }

    private fun pauseTimer() {
        countDown?.cancel()
        _viewState.value = _viewState.value.copy(
            status = Status.STARTED,
            toggle = ButtonState.RESUME
        )
    }

    fun resetTimer() {
        countDown?.cancel()
        _viewState.value = _viewState.value.copy(
            status = Status.STARTED,
            timeDuration = Duration.ofMillis(AppConstant.totalDuration),
            toggle = ButtonState.START
        )
    }

    fun buttonSelection() {
        val state = _viewState.value

        when (state?.status) {
            Status.STARTED -> {
                startTime(state.timeDuration)
            }
            Status.RUNNING -> {
                pauseTimer()
            }
            Status.FINISHED -> {
                resetTimer()
            }
            else -> {}
        }
    }
}
