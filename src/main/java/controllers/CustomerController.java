package controllers;

import db.DBHelper;
import models.Customer;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class CustomerController {

    public CustomerController() {this.setupEndPoints();}

        private void setupEndPoints(){

        get("/customers", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Customer> customers = DBHelper.getAll(Customer.class);
            model.put("template", "templates/customers/index.vtl");
            model.put("customers", customers);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("customers/:id/edit", (req, res) -> {
            String stringInt = req.params(":id");
            Integer intId = Integer.parseInt(stringInt);
            Customer customer = DBHelper.find(intId, Customer.class);

            Map<String, Object> model = new HashMap<>();
            model.put("customer", customer);
            model.put("template", "templates/customers/edit.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

            get("customers/new", (req, res) ->{
                Map<String, Object> model = new HashMap<>();
                model.put("template", "templates/customers/create.vtl");
                return new ModelAndView(model, "templates/layout.vtl");
            }, new VelocityTemplateEngine());

        get("/customers/:id", (req, res) -> {
            String stringInt = req.params(":id");
            Integer idInt = Integer.parseInt(stringInt);
            Customer customer = DBHelper.find(idInt, Customer.class);

            Map<String, Object> model = new HashMap<>();
            model.put("customer", customer);
            model.put("template", "templates/customers/show.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post("/customers/:id/delete", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Customer customerDelete = DBHelper.find(id, Customer.class);
            DBHelper.delete(customerDelete);
            res.redirect("/customers");
            return null;
        }, new VelocityTemplateEngine());

        post("/customers/:id", (req, res) -> {
            String stringInt = req.params(":id");
            Integer idInt = Integer.parseInt(stringInt);
            Customer customer = DBHelper.find(idInt, Customer.class);
            String name = req.queryParams("name");
            int loyaltyCard = Integer.parseInt(req.queryParams("loyaltyCard"));

            customer.setName(name);
            customer.setLoyaltyCard(loyaltyCard);
            DBHelper.save(customer);
            res.redirect("/customers");
            return null;
        }, new VelocityTemplateEngine());

        post("/customers", (req, res) -> {
            String name = req.queryParams("name");
            int wallet = Integer.parseInt(req.queryParams("wallet"));
            int loyaltyCard = Integer.parseInt(req.queryParams("loyaltyCard"));

            Customer customer = new Customer(name, wallet, loyaltyCard);
            DBHelper.save(customer);
            res.redirect("/customers");
            return null;
        }, new VelocityTemplateEngine());


    }
}
