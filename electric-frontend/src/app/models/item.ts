import { Category } from "./category";
import { Parameter } from './parameter';
import { Comment } from "./comment";

export class Item {
    id: number
    name: String
    status: String
    parameters: Parameter[]
    comments: Comment[]
    category: Category
}