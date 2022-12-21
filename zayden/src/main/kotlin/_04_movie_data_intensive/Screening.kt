package _04_movie_data_intensive

import java.time.LocalDateTime

class Screening(
    _movie: Movie,
    _sequence: Int,
    _whenScreened: LocalDateTime
) {
    var movie = _movie
        private set
    var sequence = _sequence
        private set
    var whenScreened = _whenScreened
        private set

    fun changeMovie(movie: Movie) {
        this.movie = movie
    }

    fun changeSequence(sequence: Int) {
        this.sequence = sequence
    }

    fun changeWhenScreened(whenScreened: LocalDateTime) {
        this.whenScreened = whenScreened
    }
}
