import groovy.swing.SwingBuilder
import groovy.beans.Bindable

import javax.swing.JOptionPane

import static javax.swing.JFrame.EXIT_ON_CLOSE
import java.awt.*


class MainForm{
    SwingBuilder theform = new SwingBuilder()
    int grade1
    int grade2
    int gradeWeight1
    int gradeWeight2
    int FinalGrade
    def GradeField1 = null;
    def GradeField2 = null;
    def GradeWeightField1 = null;
    def GradeWeightField2 = null;

    public MainForm()
    {
        CreateForm()
    }

    public static void main(String[] args)
    {
        MainForm Form = new MainForm()
    }
    public void CreateForm()
    {
        theform.edt {  // edt method makes sure UI is build on Event Dispatch Thread.
            lookAndFeel 'nimbus'  // Simple change in look and feel.
            frame(title: 'Address', size: [350, 350],
                    show: true, locationRelativeTo: null,
                    defaultCloseOperation: EXIT_ON_CLOSE) {
                borderLayout(vgap: 5)

                panel(constraints: BorderLayout.CENTER,
                        border: compoundBorder([emptyBorder(10), titledBorder("Enter A Grade")])) {
                    tableLayout {
                        tr {
                            td {
                                 label 'Grsde 1:'  // text property is default, so it is implicit.
                            }
                            td {
                                GradeField1 = textField id: 'Grade1Field', columns: 3
                            }
                        }
                        tr {
                            td {
                                label 'Grade Weight 1:'
                            }
                            td {
                                GradeWeightField1 = textField id: 'GradeWeight1Field', columns: 3
                            }
                        }
                        tr {
                            td {
                                label 'Grade 2:'
                            }
                            td {
                                GradeField2 = textField id: 'Grade2Field', columns: 3
                            }
                        }
                        tr {
                            td {
                                label 'Grade Weight 2:'
                            }
                            td {
                                GradeWeightField2 =  textField id: 'GradeWeight2Field', columns: 3
                            }
                        }
                    }

                }

                panel(constraints: BorderLayout.SOUTH) {
                    button text: 'Calculate Weighted Grade ', actionPerformed: {
                        grade1 = Integer.parseInt(GradeField1.getText())
                        grade2 = Integer.parseInt(GradeField2.getText())
                        gradeWeight1 = Integer.parseInt(GradeWeightField1.getText())
                        gradeWeight2 = Integer.parseInt(GradeWeightField2.getText())
                        if((gradeWeight1 + gradeWeight2 ) != 100)
                        {
                            JOptionPane.showMessageDialog(null,"Grade Weightings must total 100")
                            return
                        }
                        else {
                            FinalGrade = (int) (grade1 / 100 * gradeWeight1) + (grade2 / 100 * gradeWeight2)
                            JOptionPane.showMessageDialog(null, "The Weighted Grade is " + FinalGrade)
                        }
                    }
                }

            }
        }
    }

}




