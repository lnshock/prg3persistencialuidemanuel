import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.dao.CursoDao;
import javax.swing.*;
import java.awt.*;

public class CursoSave extends JFrame {
    
   
    private CursoDao cursoDao; // Use o DAO

    private JTextField txtNome, txtCodigo;
    private JCheckBox chkAtivo;

    public CursoSave() {
        cursoDao = new CursoDao(); // Inicializa o DAO
        
        setTitle("Cadastrar / Editar Curso");
        setSize(400, 300);
     

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(e -> {
            try {
                Curso curso = new Curso();
                curso.setNome(txtNome.getText());
                curso.setCodigoCurso(txtCodigo.getText());
                curso.setAtivo(chkAtivo.isSelected());

               
                cursoDao.save(curso);

                JOptionPane.showMessageDialog(null, "Curso salvo com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex.getMessage());
            }
        });
        
        add(btnSalvar);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());
        add(btnCancelar);
    }
}