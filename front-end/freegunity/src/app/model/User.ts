import { Postagem } from "./Postagem"

// Classe do back-end que vai ser exportada
export class User {
    public id: number
    public nome: string
    public username: string
    public foto: string
    public email: string
    public senha: string
    public admin: string

    // Relacionamento entre as classes
    public postagem: Postagem[]
}