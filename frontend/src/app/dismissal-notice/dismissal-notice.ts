import { Address } from "./address";

export class DismissalNotice {
  firstName: string;
  lastName: string;
  homeAddress: Address;
  companyName: string;
  companyAddress: Address;
  agreementDate: string;
  dismissalDate: string;
  dismissalPlace: string;
}
