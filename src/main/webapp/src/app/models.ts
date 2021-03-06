export class Order {
  static count: number = 0;

  id: any = `0-${Order.count++}`;
  customerId: number = 0;
  lastName: string = '';
  firstName: string = '';
  phoneNumber: string = '';
  city: string = '';
  postOffice: string = '';
  totalSum: number = 0;
  paymentType: string = 'NP';
  date: any = new Date();
  status: string = 'NEW';
  comment: string = '';
  orderItemDtos: Product[] = [new Product()];
}

export class Product {
  static count: number = 0;

  id: any = `0-${Product.count++}`;
  productId?: number = 0;
  productVariationId?: number = 0;
  name: string = '';
  categories?: string[] = [''];
  quantity: string = '0';
  price: string = '0';
  supplier: string = '';
}

export class AutocompleteItem {
  label: string = '';
}

export class StaticDATA {
  static readonly infoBlocks = {
    status: ['SHP', 'WFP', 'OK', 'NEW', 'NOT'],
    paymentType: ['PB', 'SV', 'NP']
  };

  static readonly autocompleteBlocks = ['lastName', 'phoneNumber', 'city', 'name'];

  static readonly keycodesNotToAutocomplete = [9, 13, 16, 17, 18, 20]; // Tab, Enter, Shift, Ctrl, Alt, Caps Lock

  static readonly sessionTime = 235 * 60 * 1000; // minutes
}

