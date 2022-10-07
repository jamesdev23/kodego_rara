package exercise_1

import java.time.LocalDate
import java.time.Month
import java.time.format.DateTimeFormatter
import java.util.Date

fun main() {
    // declaring variables
    // top part
    var applyingFor: String? = null
    var desiredSalary: String? = null
    var workStartDate = LocalDate.parse("2022-10-30")
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
    var isUSCitizen: String? = "No"
    var haveFelony: String? = "No"
    var willDoDrugTest: String? = "Yes"

    // education var
    var schoolName1: String? = null
    var schoolName2: String? = null
    var schoolName3: String? = null
    var location1: String? = null
    var location2: String? = null
    var location3: String? = null
    var yearsAttended1: String? = null
    var yearsAttended2: String? = null
    var yearsAttended3: String? = null
    var degreeReceived1: String? = null
    var degreeReceived2: String? = null
    var degreeReceived3: String? = null
    var major1: String? = null
    var major2: String? = null
    var major3: String? = null
    var otherTraining: String? = null

    // birthdate, age
    var birthDate = LocalDate.parse("1991-10-15")
    var formattedBday = birthDate.format(dateFormat)
    var age = 30
    //var minorAgeRange: IntRange = 0..17

    // personal info output
    println("Application for Employment")
    println("Position You Are Applying For: $applyingFor ")
    println("Desired Salary: $desiredSalary")
    println("Date Available for Work: $formattedWorkStartDate")

    println("Personal Information")
    println("Last Name: $lastName")
    println("First Name: $firstName")
    println("Middle: $middleName")
    println("Birthdate: $formattedBday")
    println("Age: $age")
    if (age in 1..17) {
        println("Minor: Yes")
    } else {
        println("Minor: No")
    }

    println("Address: $address")
    println("City: $city")
    println("State: $state")
    println("Zip: $zip")
    println("Home Phone: $homePhone")
    println("Cell Phone: $cellPhone")
    println("Email Address: $emailAddress")
    println("Social Security Number: $ssNumber")
    println("Are you a U.S. Citizen? $isUSCitizen")
    println("Have you ever been convicted of a felony? $haveFelony")
    println("If selected for employment are you willing to submit to a pre-employment drug screening test?: $willDoDrugTest")

    // education output
    println("Education")
    println(
        "School Name: $schoolName1 | " +
                "Location: $location1 | " +
                "Years Attended: $yearsAttended1 | " +
                "Degree Received: $degreeReceived1 | " +
                "Major: $major1"
    )
    println(
        "School Name: $schoolName2 | " +
                "Location: $location2 | " +
                "Years Attended: $yearsAttended2 | " +
                "Degree Received: $degreeReceived2 | " +
                "Major: $major2"
    )
    println(
        "School Name: $schoolName3 | " +
                "Location: $location3 | " +
                "Years Attended: $yearsAttended3 | " +
                "Degree Received: $degreeReceived3 | " +
                "Major: $major3"
    )
    println("Other training, certifications or licenses held: $otherTraining")
}



