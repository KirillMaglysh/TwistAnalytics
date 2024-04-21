package com.mktech.twistanalytics.requests

import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.lang.NonNull
import org.springframework.lang.Nullable
import java.io.Serializable

@Schema(description = "Employees request")
class EmployeesRequest(
    @Nullable
    @Schema(description = "Limit", example = "10")
    val limit: Int = 10,

    @Nullable
    @Schema(description = "Offset", example = "0")
    val offset: Int = 0
) : Serializable {
    override fun toString(): String {
        return "{limit = $limit offset=$offset}"
    }
}
