# Enunciado da Atividade
1. Clone o repositório

1. Abra o projeto, que é implementado em Java com Spring Boot e Maven

1. Responda às questões abaixo:
    1. Quais são os endpoint implementados?
        a. /delete/student/{regdNum}
        b. /register/student
        c. /student/allstudent
        d. /update/student
    2. Quais são as entradas destes endpoints (tipos e formatos)?
        a. @DeleteMapping -- String regdNum
        b. @PostMapping -- Student student
        c. @GetMapping -- Sem entrada
        d. @PutMapping -- Student stdn
    3. Quais são as saídas?
        a. Deleta uma instância de StudentRegistration
        b. Retorna um novo StudentRegistrationReply
        c. Retorna uma lista de Student
        d. Atualiza uma instância de Student
1. Testem cada endpoint.
        r. https://subscriptionmanagement-8936.postman.co/workspace/FDS-Workspace~ba976f11-c95a-47d9-875a-82501591710a/collection/34197698-f9200b9c-be0f-492f-b69a-987424e91bc8?action=share&creator=34197698
1. Implemente uma funcionalidade simples de gestão de disciplinas:
    1. criação de disciplinas
        r. SubjectManager.java
    1. Código da disciplina, descrição e código da turma
        r. Subject.java
    1. não permitir disciplinas com código duplicado
        r. SubjectManager.java
    1. listar todas as disciplinas criadas
        r. SubjectManager.java