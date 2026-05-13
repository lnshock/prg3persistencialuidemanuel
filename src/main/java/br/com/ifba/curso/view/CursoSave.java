package br.com.ifba.curso.view;

import br.com.ifba.curso.controller.CursoController;
import br.com.ifba.curso.controller.ICursoController;
import br.com.ifba.curso.entity.Curso;
import javax.swing.*;
import java.awt.*;

public class CursoSave extends JFrame {
    
    
    private final ICursoController cursoController = new CursoController();
    private JTextField txtNome = new JTextField(20);
    private JTextField txtCodigo = new JTextField(10);
    private JCheckBox chkAtivo = new JCheckBox("Ativo");

    public CursoSave() {
        setTitle("Cadastro de Curso");
        setSize(400, 200);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(new JLabel("Nome:"));
        add(txtNome);
        add(new JLabel("Código:"));
        add(txtCodigo);
        add(chkAtivo);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(e -> {
            try {
                Curso curso = new Curso();
                curso.setNome(txtNome.getText());
                curso.setCodigoCurso(txtCodigo.getText());
                curso.setAtivo(chkAtivo.isSelected());

                // Chamada via controller
                cursoController.save(curso);

                JOptionPane.showMessageDialog(null, "Curso salvo com sucesso!");
                this.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            }
        });

        add(btnSalvar);
        setVisible(true);
    }
}
