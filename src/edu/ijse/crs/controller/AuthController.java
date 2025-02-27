/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.crs.controller;

import edu.ijse.crs.service.AuthService;

class AuthController {
    private AuthService authService;

    public AuthController() {
        this.authService = new AuthService();
    }

    public boolean login(String username, String password) {
        return authService.validateUser(username, password);
    }
}
