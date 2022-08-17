package util;

import DAO.ProdutoDAO;
import java.util.ArrayList;
import javax.swing.JComboBox;
import model.Produto;

public class PedidoUtil {
    
    public static void carregarNomeProdutos(JComboBox produtos) throws ClassNotFoundException    {
        
        ArrayList<Produto> listaProdutos = new ProdutoDAO().listarProduto();
        
        //remover os itens da combobox
        produtos.removeAllItems();
        
        //primeiro item
        produtos.addItem("Selecione um produto");
        
        //carregar lista
        for(Produto produto: listaProdutos){
            produtos.addItem(produto.getNomeProduto());
        }
    }
}
