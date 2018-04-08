package com.esipovich.masterclass.interfaces;

import java.util.List;

/**
 * @author Artem Esipovich 08.04.2018
 */

public interface Saveable {

    void read(List<String> savedValues);

    List<String> write();
}
