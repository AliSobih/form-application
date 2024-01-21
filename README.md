# form-application

This project is used to apply for a job, where the applicant fills out a job form and then the specialists respond to this form with acceptance or rejection.
In one job application, more than one job position can be applied for, and the work team can accept one or all of these positions
If one of these positions is accepted, the person will be placed on a waiting list to receive work

## APIs
### 1. Aplication API

- **Description:** Manages application information.
- **Actions:**
  - GET `/api/application` - Get all applications.
  - POST `/api/application` - Add a new application.
  - GET `/api/skill/{id}` - Get application by ID.
  - PUT `/api/skill/{id}` - Update application information.
  - DELETE `/api/skill/{id}` - Delete application by ID.
- *Sample Screenshot:*
    - ![Screenshot 2024-01-21 150334](https://github.com/AliSobih/form-application/assets/43109825/77c386b9-0063-42a1-ac22-07523f2f9cfb)
    - ![Screenshot 2024-01-21 150646](https://github.com/AliSobih/form-application/assets/43109825/d30397e9-f6d0-4ef6-a8e9-a02ff9b931c0)

### 2. Interview Group API

- **Description:** Manages making decision.
- **Actions:**
  - POST `/api/interview_group` - accept or reject applicant.
- *Sample Screenshot:*
  - ![Screenshot 2024-01-21 150415](https://github.com/AliSobih/form-application/assets/43109825/83a297f0-dc5a-45c1-b3a3-6f5d4b76af75)
  - ![Screenshot 2024-01-21 150828](https://github.com/AliSobih/form-application/assets/43109825/2acc1e5e-e790-4aec-ba2e-473033856be4)



### 3. Skill API

- **Description:** Manages Skills.
- **Actions:**
  - GET `/api/skill` - Get all skills.
  - POST `/api/skill` - Add a new skill.

  - GET `/api/skill/{id}` - Get skill by ID.
  - PUT `/api/skill/{id}` - Update skill information.
  - DELETE `/api/skill/{id}` - Delete skill by ID.
- *Sample Screenshot:*
  - ![Screenshot 2024-01-21 150241](https://github.com/AliSobih/form-application/assets/43109825/1e0adf4e-5783-48cb-940d-aa5fff58883f)
  - ![Screenshot 2024-01-21 150754](https://github.com/AliSobih/form-application/assets/43109825/0f7a8b8c-bd17-4432-911f-60d295c3bd9e)


  
## ERD diagram
![Screenshot 2024-01-21 171913](https://github.com/AliSobih/form-application/assets/43109825/76571c7e-2088-4d49-85f6-f0c915477ad4)


## Dependencies:
 - Spring boot
 - Spring data jpa
 - Mysql driver
 - Lombok
 - Validation

