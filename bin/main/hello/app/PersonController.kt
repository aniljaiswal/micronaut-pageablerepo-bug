package hello.app

import io.micronaut.data.annotation.Query
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.QueryValue
import jakarta.inject.Inject

@Controller("/")
class PersonController {

    @Inject
    private lateinit var personService: PersonService

    @Get(uri = "/", produces = ["application/json"])
    suspend fun index(@QueryValue("q") searchTerm: String, pageable: Pageable): Page<Person> {
        return personService.list(searchTerm, pageable)
    }

    @Post(uri = "/", produces = ["application/json"])
    suspend fun create(): Person {
        val name = "John Doe"
        return personService.addPerson(name)
    }
}
