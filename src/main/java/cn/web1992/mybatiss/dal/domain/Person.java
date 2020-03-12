package cn.web1992.mybatiss.dal.domain;

import java.sql.Timestamp;

public class Person {

    private Integer personId;

    private String firstName;

    private String lastName;

    private String operationBy;

    private Timestamp operationAt;

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOperationBy() {
        return operationBy;
    }

    public void setOperationBy(String operationBy) {
        this.operationBy = operationBy;
    }

    public Timestamp getOperationAt() {
        return operationAt;
    }

    public void setOperationAt(Timestamp operationAt) {
        this.operationAt = operationAt;
    }


    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", operationBy='" + operationBy + '\'' +
                ", operationAt=" + operationAt +
                '}';
    }
}
