# Hibernate-SpringBoot-MySQL
This Project demonstrates the usage of Hibernate, OnetoOne, OnetoMany, ManytoMany Relationship

INSTRUCTIONS

IDE for SpringBoot, PostgreSQL and API testing tool like PostMan are required for this project

API TESTING ( Open your API Testing Tool )

1. Add Student

        POST METHOD
        localhost:8080/api/post

         {
            "student": {
              "name": "sampleData"
            }
          }


2. Get Student by ID with a registered Course

        GET METHOD
        localhost:8080/api/1

       {
        "student": {
            "id": 1,
            "name": "marlo",
            "course": {
                "id": 1,
                "name": "Bachelor of Science in Information Technology"
              }
            }
        }

3. Get a Course with its corresponding Subjects

        GET METHOD
        localhost:8080/api/2/subjects

       {
        "subjects": [
            {
                "id": 3,
                "name": "Algorithm",
                "course": {
                    "id": 2,
                    "name": "Bachelor of Science in Computer Science\r\n"
                  }
              }
            ]
        }







