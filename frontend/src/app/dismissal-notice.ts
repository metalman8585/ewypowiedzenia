import { Address } from "./address";

export class DismissalNotice {
  firstName: string;
  lastName: string;
  homeAddress: Address;
  companyName: string;
  companyAddress: Address;
  agreementDate: Date;
  dismissalDate: Date;
  dismissalPlace: string;

  constructor() {
    this.homeAddress = new Address;
    this.companyAddress = new Address;
    this.agreementDate = null;
    this.dismissalDate = null;
  }

}
