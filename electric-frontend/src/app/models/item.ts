import { Category } from './category';
import { Parameter } from './parameter';
import { Comment } from './comment';

export class Item {
    id: number;
    name: string;
    status: string;
    parameters: Parameter[];
    comments: Comment[];
    category: Category;
}
