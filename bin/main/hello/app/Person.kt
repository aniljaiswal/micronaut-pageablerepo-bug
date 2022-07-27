package hello.app

import io.micronaut.core.annotation.Introspected
import io.micronaut.data.annotation.AutoPopulated
import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity

@Introspected
@MappedEntity(value = "person")
data class Person(
    @AutoPopulated
    @field:Id var id: Long?,

    var name: String
)
