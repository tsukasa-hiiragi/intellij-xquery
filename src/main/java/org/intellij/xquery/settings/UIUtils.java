/*
 * Copyright 2013-2014 Grzegorz Ligas <ligasgr@gmail.com> and other contributors
 * (see the CONTRIBUTORS file).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.intellij.xquery.settings;

import com.intellij.openapi.ui.LabeledComponent;
import com.intellij.ui.SortedComboBoxModel;

import javax.swing.*;
import java.util.Comparator;

public class UIUtils {
    static SortedComboBoxModel<Object> comboBoxModel() {
        return new SortedComboBoxModel<Object>(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).compareToIgnoreCase((String) o2);
            }
        });
    }

    static LabeledComponent<JComboBox> comboBox(String text, String name, SortedComboBoxModel<Object> model) {
        LabeledComponent<JComboBox> comboBox = new LabeledComponent<JComboBox>();
        comboBox.setText(text);
        comboBox.setLabelLocation("West");
        comboBox.setComponent(new JComboBox());
        comboBox.getComponent().setName(name);
        comboBox.getComponent().setModel(model);
        return comboBox;
    }
}
