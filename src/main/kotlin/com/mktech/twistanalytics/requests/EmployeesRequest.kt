package com.mktech.twistanalytics.requests

import com.mktech.twistanalytics.utils.EmployeeTableHeader
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import org.springframework.lang.Nullable
import java.io.Serializable

@Schema(description = "Employees request")
class EmployeesRequest(
    @Nullable
    @Min(0)
    @Schema(description = "Limit", example = "10")
    var limit: Int = 8,

    @Nullable
    @Min(0)
    @Schema(description = "Offset", example = "0")
    var offset: Int = 0,

    @NotBlank
    @Pattern(regexp = "id|name|surname|email|phone|role", flags = [Pattern.Flag.CASE_INSENSITIVE])
    @Schema(description = "sortParam", example = "id")
    var sortParam: String = "id",

    @Nullable
    @Schema(description = "isAsk", example = "1")
    var isAsc: Boolean = true,
) : Serializable {
    fun validate(employeeTableHeaders: List<EmployeeTableHeader>) {
        var found = false
        for (tableParam in employeeTableHeaders) {
            if (tableParam.enName == sortParam) {
                found = true
                break
            }
        }

        if (!found) {
            sortParam = "id"
        }
    }

    override fun toString(): String {
        return "{limit=$limit offset=$offset param=$sortParam isAsc=$isAsc}"
    }
}
