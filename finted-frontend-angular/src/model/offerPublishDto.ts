/**
 * OpenAPI definition
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
import { PostDto } from './postDto';
import { UserDto } from './userDto';

export interface OfferPublishDto { 
    id?: number;
    post?: PostDto;
    user?: UserDto;
    publishDate?: Date;
    offer?: number;
}