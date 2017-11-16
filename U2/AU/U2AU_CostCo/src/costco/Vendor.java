/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package costco;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Darian
 */
public class Vendor {
    
    private String name;
    private String address;
    private int yearStarted;
    private String contact;
    private List<String> items;

    /**
     * Create a new instance of Vendor
     * @param name Name of vendor
     * @param address Address of vendor
     * @param yearStarted Year vendor started working with CostCo
     * @param contact Name of contact person
     */
    public Vendor(String name, String address, int yearStarted, String contact) {
        this.name = name;
        this.address = address;
        this.yearStarted = yearStarted;
        this.contact = contact;
        items = new ArrayList<>();
    }

    /**
     * Get the vendor name
     * @return Vendor's name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the vendor name
     * @param name Vendor's new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get vendor address
     * @return Vendor Address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set vendor address
     * @param address Vendor's new address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get the year this vendor started dealing with CostCo
     * @return Year vendor started dealing with CostCo
     */
    public int getYearStarted() {
        return yearStarted;
    }

    /**
     * Set the year this vendor started dealing with CostCo
     * @param yearStarted New year
     */
    public void setYearStarted(int yearStarted) {
        this.yearStarted = yearStarted;
    }

    /**
     * Get main person of contact
     * @return Name of contact person
     */
    public String getContact() {
        return contact;
    }

    /**
     * Set main person of contact
     * @param contact Name of new contact person
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * Get items supplied by this vendor
     * @return List of items
     */
    public List<String> getItems() {
        return items;
    }
    
    public void addItem(String item){
        items.add(item);
    }
    
    public void removeItem(String item){
        items.remove(item);
    }
    
}
