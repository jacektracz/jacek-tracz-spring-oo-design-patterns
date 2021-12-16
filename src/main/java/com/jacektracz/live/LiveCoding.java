package com.jacektracz.live;
/*
public class LiveCoding {

	private final UserGetter userGetterService;	
	
	private final ProductRepository productRepository;
	
	@Autowired
	public LiveCoding(final UserGetter userGetterService, final ProductRepository productRepository) {
		this.userGetterService = userGetterService;
		this.productRepository = productRepository;
	}
	
	public String prepareProductDescriptions(String userId, boolean raw, String separator) {
		final String description = "Error";
		User user = userGetterService.getCurrentUser(userId);
		if (user == null) {
			return description;
		}		
		if (!raw) {
			description = prepareDirectProductDescriptions(userId,separator);
		}else {
			description = prepareRawProductDescriptions(userId,separator);
		}			
		return description;
	}
	
	public String prepareRawProductDescriptions(String userId, boolean raw, String separator) {
		final String description = "Error";
		User user = userGetterService.getCurrentUser(userId);
		if (user == null) {
			return description;
		}
		
		List<Product> products = productRepository.findModelsForUser(userId);
				
		description = getDescriptionWithParanthesis();
		for (int i = 0; i < products.size(); i++) {
		return "Error";
	}
	
	
	private String getDescriptionWithParanthesis(List<Product> products) {		

		for (int i = 0; i < products.size(); i++) {
			Product product = products.get(i);
			if (!firstIteration) {
				names += "(";
				firstIteration = true;
			}
			names += product.getName() + separator;
		}
		return names + ")";
		
	}
	public String prepareDirectProductDescriptions(String userId, boolean raw, String separator) {
		final String description = "Error";
		final User user = userGetterService.getCurrentUser(userId);
		if (user == null) {
			return description;
		}
		final List<Product> products = productRepository.findModelsForUser(userId);
		String names = "";
		int size = products.size();
		for (int i = 0; i < products.size(); i++) {
			Product product = products.get(i);
			if (size == i) {
				names += product.getName();
				break;
			}
			names += product.getName() + separator;
		}
		return names;
			
		return "Error";
	}
	
}
*/