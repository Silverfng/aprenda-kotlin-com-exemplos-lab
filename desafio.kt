// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, val email: String)

data class ConteudoEducacional(
    var nome: String,
    val duracao: Int, // duração em horas
    val descricao: String = ""
)

data class Formacao(
    val nome: String,
    val nivel: Nivel,
    var conteudos: List<ConteudoEducacional>
) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} foi matriculado na formação $nome.")
    }

    fun listarInscritos() {
        println("Inscritos na formação $nome:")
        inscritos.forEach { println("- ${it.nome} (${it.email})") }
    }

    fun duracaoTotal(): Int {
        return conteudos.sumOf { it.duracao }
    }
}

fun main() {
    // Criando conteúdos educacionais
    val kotlinBasico = ConteudoEducacional("Introdução ao Kotlin", 8, "Fundamentos da linguagem Kotlin")
    val poo = ConteudoEducacional("Programação Orientada a Objetos", 12, "Conceitos de classes e objetos")
    val springBoot = ConteudoEducacional("Spring Boot", 20, "Framework para aplicações Java")

    // Criando formação
    val formacaoBackend = Formacao(
        nome = "Formação Backend Developer",
        nivel = Nivel.INTERMEDIARIO,
        conteudos = listOf(kotlinBasico, poo, springBoot)
    )

    // Criando usuários
    val usuario1 = Usuario("Maria Silva", "maria@dio.com")
    val usuario2 = Usuario("João Souza", "joao@dio.com")

    // Matriculando usuários
    formacaoBackend.matricular(usuario1)
    formacaoBackend.matricular(usuario2)

    // Listando inscritos
    formacaoBackend.listarInscritos()

    // Exibindo duração total da formação
    println("Duração total da formação: ${formacaoBackend.duracaoTotal()} horas")
}