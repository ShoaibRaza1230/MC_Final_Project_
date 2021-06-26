package com.example.tableorder;

public class Tables {
    private int floorNo;
    private int tableNo;
    private int capacity;
    private int image;
    private String tableCode;
    private int status;

    public Tables(int floorNo, int tableNo, int capacity,String tableCode)
    {
        this.floorNo=floorNo;
        this.tableNo=tableNo;
        this.capacity=capacity;
        this.status=0;
        this.image=R.drawable.table;
        this.tableCode = tableCode;
    }

    @Override
    public String toString() {
        return "Tables{" +
                "floorNo=" + floorNo +
                ", tableNo=" + tableNo +
                ", capacity=" + capacity +
                '}';
    }
    public int isStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public int getTableNo() {
        return tableNo;
    }

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public String getTableCode() {
        return tableCode;
    }

    public void setTableCode(String tableCode) {
        this.tableCode = tableCode;
    }


}
