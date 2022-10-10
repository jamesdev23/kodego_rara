package exercise_1

import java.time.LocalDate
import java.time.format.DateTimeFormatter

// Changes: - fixed data type of some variables | - removed personal infos like birthdate and replaced dates with filler date.

fun main() {
    // declaring variables
    var applyingFor: String?
    var desiredSalary: Float? = null
    var workStartDate = LocalDate.parse("2023-01-01")   // filler date

    // date format
    var dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy")
    var formattedWorkStartDate = workStartDate.format(dateFormat)

    // personal information
    var lastName: String? = null
    var firstName: String? = null
    var middleName: String? = null
    var address: String? = null
    var city: String? = null
    var state: String? = null
    var zip: Int? = null
    var homePhone: Long? = null
    var cellPhone: Long? = null
    var emailAddress: String? = null
    var ssNumber: Long? = null
    var isUSCitizen: Boolean? = null
    var haveFelony: Boolean? = null
    var willDoDrugTest: Boolean? = null

    // birthdate, age
    var birthDate = LocalDate.parse("1991-01-01")   // filler date
    var formattedBday = birthDate.format(dateFormat)
    var age: Int? = null
    var minorAgeRange: IntRange = 0..17

    // education var
    var schoolName1: String? = null
    var schoolName2: String? = null
    var schoolName3: String? = null
    var location1: String? = null
    var location2: String? = null
    var location3: String? = null
    var yearsAttended1: Int? = null
    var yearsAttended2: Int? = null
    var yearsAttended3: Int? = null
    var degreeReceived1: String? = null
    var degreeReceived2: String? = null
    var degreeReceived3: String? = null
    var major1: String? = null
    var major2: String? = null
    var major3: String? = null
    var otherTraining: String? = null

    // 10-9-22 tbc
}