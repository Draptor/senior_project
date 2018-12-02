package com.example.kylet.testingjson;

class Lab {
    private int available_machines;
    private int total_machines;
    private int lab_id;
    private String lab_name;

    public Lab(int available_machines, int total_machines, int lab_id, String lab_name){
        this.available_machines = available_machines;
        this.total_machines = total_machines;
        this.lab_id = lab_id;
        this.lab_name = lab_name;
    }

    public String getLab_name(){
        return this.lab_name;
    }

    public void setLab_name(String labName){
        this.lab_name = labName;
    }

    public int getLab_id(){
        return lab_id;
    }

    public void setLab_id(int labId){
        this.lab_id = labId;
    }

    public int getTotal_machines(){
        return total_machines;
    }

    public void setTotal_machines(int totalMachines){
        this.total_machines = totalMachines;
    }

    public int getAvailable_machines(){
        return available_machines;
    }

    public void setAvailable_machines(int availableMachines){
        this.available_machines = availableMachines;
    }
}
