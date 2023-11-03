const produtos = [];
const clientes = [];
const vendas = [];
const formasDePagamento = ["Dinheiro", "PIX", "Crédito", "Débito", "VA", "VR", "Outras opções"];
const estoque = [];
const historicoVendas = [];

function cadastrarProduto(nome, codigoDeBarras, preco, quantidade, fornecedor, descricao) {
  const produto = {
    nome,
    codigoDeBarras,
    preco,
    quantidade,
    fornecedor,
    descricao
  };
  produtos.push(produto);
}

function cadastrarCliente(nome, endereco, telefone, email, cpfOuCnpj) {
  const cliente = {
    nome,
    endereco,
    telefone,
    email,
    cpfOuCnpj
  };
  clientes.push(cliente);
}

function registrarVenda(produtosSelecionados, clienteSelecionado, quantidadeVendida, formaDePagamento, dataEHora) {
  const valorTotal = calcularValorTotal(produtosSelecionados);
  const venda = {
    produtos: produtosSelecionados,
    cliente: clienteSelecionado,
    quantidadeVendida,
    formaDePagamento,
    valorTotal,
    dataEHora
  };
  vendas.push(venda);
  atualizarEstoque(produtosSelecionados);
  historicoVendas.push(venda);
}

function calcularValorTotal(produtosSelecionados) {
  let total = 0;
  produtosSelecionados.forEach(produto => {
    total += produto.preco;
  });
  return total;
}

function atualizarEstoque(produtosSelecionados) {
  produtosSelecionados.forEach(produto => {
    const estoqueItem = estoque.find(item => item.codigoDeBarras === produto.codigoDeBarras);
    if (estoqueItem) {
      estoqueItem.quantidade -= produto.quantidade;
    } else {
      console.log("Produto não encontrado no estoque.");
    }
  });
}

function verificarEstoqueBaixo() {
  const estoqueBaixo = estoque.filter(item => item.quantidade <= 10);
  return estoqueBaixo;
}

// Função para reabastecer o estoque
function reabastecerEstoque(codigoDeBarras, quantidade) {
  const produto = produtos.find(item => item.codigoDeBarras === codigoDeBarras);
  if (produto) {
    const estoqueItem = estoque.find(item => item.codigoDeBarras === codigoDeBarras);
    if (estoqueItem) {
      estoqueItem.quantidade += quantidade;
    } else {
      console.log("Produto não encontrado no estoque.");
    }
  } else {
    console.log("Produto não encontrado.");
  }
}

// Função para pesquisar e filtrar o histórico de vendas
function pesquisarHistoricoVendas(filtro) {
  const resultado = historicoVendas.filter(venda => {
    // Implemente aqui a lógica de filtragem com base no filtro fornecido
    // Exemplo: 
    // if (venda.cliente.nome.includes(filtro) || venda.produtos.some(produto => produto.nome.includes(filtro))) {
    //   return true;
    // }
    // return false;
  });
  return resultado;
}

cadastrarProduto("Produto 1", "12345", 10.99, 100, "Fornecedor A", "Descrição do Produto 1");
cadastrarProduto("Produto 2", "54321", 19.99, 50, "Fornecedor B", "Descrição do Produto 2");
cadastrarCliente("Cliente A", "Rua A, 123", "123456789", "clienteA@email.com", "123.456.789-00");
cadastrarCliente("Cliente B", "Rua B, 456", "987654321", "clienteB@email.com", "98.765.432/0001-00");

const produtosSelecionados = [produtos[0], produtos[1]];
const clienteSelecionado = clientes[0];
registrarVenda(produtosSelecionados, clienteSelecionado, 2, "Crédito", new Date());

console.log("Produtos em estoque:", produtos);
console.log("Clientes cadastrados:", clientes);
console.log("Vendas registradas:", vendas);
console.log("Estoque atualizado:", estoque);
console.log("Histórico de vendas:", historicoVendas);
