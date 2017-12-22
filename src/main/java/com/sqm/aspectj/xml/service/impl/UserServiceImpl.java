package com.sqm.aspectj.xml.service.impl;

import com.sqm.aspectj.xml.service.UserService;

/**
 * <p>
 *
 * @author sqm
 * @version 1.0
 */
public class UserServiceImpl implements UserService {
    public String doThird() {
        System.out.println(this.getClass().getSimpleName() + " doThird()");
        return "3";
    }

    public void doSome() {
        System.out.println(this.getClass().getSimpleName() + " doSome()");
    }

    public int doOther(int a, String b) {
        System.out.println(this.getClass().getSimpleName() + " doOther(" + a +"," + b + ")");
        return a;
    }
}
