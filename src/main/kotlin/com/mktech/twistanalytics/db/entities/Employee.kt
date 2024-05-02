package com.mktech.twistanalytics.db.entities

import jakarta.annotation.Nonnull
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.io.Serializable

@Entity
class Employee(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Nonnull
    val phone: String? = null,

    @Nonnull
    val email: String? = null,

    @Nonnull
    val name: String? = null,

    @Nonnull
    val surname: String? = null,

    @Nonnull
    val password: String? = null,

    val role: Role? = null
) {
    enum class Role(private val numType: Int) {
        COACH(0), ADMIN(1), BOSS(2);

        override fun toString(): String {
            return when (numType) {
                0 -> "Тренер"
                1 -> "Админ"
                2 -> "Босс"
                else -> "Undefined"
            }
        }
    }

    class EmployeeWoPsw(
        val id: Long,
        val phone: String,
        val email: String,
        val name: String,
        val surname: String,
        val role: Role
    ) : Serializable
}
