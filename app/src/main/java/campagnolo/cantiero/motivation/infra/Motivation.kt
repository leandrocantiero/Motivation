package campagnolo.cantiero.motivation.infra

class Motivation private constructor() {
    object key {
        val PERSON_NAME = "name"
    }

    object fraseFilter {
        val ALL = 1
        val HAPPY = 2
        val SUN = 3
    }
}