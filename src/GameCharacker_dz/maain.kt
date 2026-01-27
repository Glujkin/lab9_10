package GameCharacker_dz

fun main() {
    val hero = GameCharacter("Герой")

    // Меняем состояния
    hero.state = Running
    process(hero.state)

    hero.state = Attack(35)
    process(hero.state)

    hero.state = Death("споткнулся об воздух")
    process(hero.state)
}

fun process(state: CharacterState) {
    when (state) {
        is Idle -> println("Стоит")
        is Running -> println("Бежит")
        is Attack -> println("Бьет с уроном ${state.damage}")
        is Death -> println("Умер: ${state.reason}")
    }
}