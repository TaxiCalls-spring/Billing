/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxicalls.billing.model;

import java.io.Serializable;

/**
 *
 * @author romulo
 */
public enum Progress implements Serializable {
    MOVING_TO, IN_PROGRESS, CONCLUDED;
}
