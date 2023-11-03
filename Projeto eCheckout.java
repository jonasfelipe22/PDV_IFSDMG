@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String barcode;
    private Double price;
    private Integer quantity;
    private String suppliers;
    private String description;
    // getters and setters
}

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String document;
    // getters and setters
}

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private Integer quantity;
    private Double totalAmount;
    private LocalDateTime date;
    private String paymentMethod;
    // getters and setters
}

@RestController
@RequestMapping("/api/v1/")
public class CheckoutController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private SaleRepository saleRepository;

    // implement your API endpoints here
}