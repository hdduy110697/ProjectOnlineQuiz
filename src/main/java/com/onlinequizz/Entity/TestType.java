package com.onlinequizz.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Test_type")
public class TestType {
    @Id
    @Column(name = "test_type_id")
    private String testTypeId;
    @Column(name = "test_type_name")
    private String testTypeName;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "test_type_id")
    private Set<Test> listTest;

    public Set<Test> getListTest() {
        return listTest;
    }

    public void setListTest(Set<Test> listTest) {
        this.listTest = listTest;
    }

    public String getTestTypeId() {
        return testTypeId;
    }

    public void setTestTypeId(String testTypeId) {
        this.testTypeId = testTypeId;
    }

    public String getTestTypeName() {
        return testTypeName;
    }

    public void setTestTypeName(String testTypeName) {
        this.testTypeName = testTypeName;
    }
}
