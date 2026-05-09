
import br.com.ifba.curso.entity.Curso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javax.swing.*;
import java.awt.*;

public class CursoSave extends JFrame {
    
   
    private final static EntityManagerFactory entityManagerFactory = 
            Persistence.createEntityManagerFactory("gerenciamento_curso");
    private final static EntityManager entityManager = 
            entityManagerFactory.createEntityManager();

    private JTextField txtNome, txtCodigo;
    private JCheckBox chkAtivo;

    public CursoSave() {
        setTitle("Cadastrar / Editar Curso");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("Nome do Curso:"));
        txtNome = new JTextField();
        add(txtNome);

        add(new JLabel("Código do Curso:"));
        txtCodigo = new JTextField();
        add(txtCodigo);

        add(new JLabel("Ativo:"));
        chkAtivo = new JCheckBox("Sim");
        add(chkAtivo);

        JButton btnSalvar = new JButton("Salvar");
        // Lógica de salvar com tratamento de exceções 
        btnSalvar.addActionListener(e -> {
            try {
                Curso curso = new Curso();
                curso.setNome(txtNome.getText());
                curso.setCodigoCurso(txtCodigo.getText());
                curso.setAtivo(chkAtivo.isSelected());

                // Iniciando transação e salvando 
                entityManager.getTransaction().begin();
                entityManager.persist(curso);
                entityManager.getTransaction().commit();

                JOptionPane.showMessageDialog(null, "Curso salvo com sucesso!");
            } catch (Exception ex) {
                // Captura e trata a condição anormal [cite: 787, 851]
                JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex.getMessage());
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
            }
        });
        
        add(btnSalvar);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());
        add(btnCancelar);
    }
}