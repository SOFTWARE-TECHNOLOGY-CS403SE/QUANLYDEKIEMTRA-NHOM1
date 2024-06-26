import React from 'react';
import {
  Box,
  Flex,
  Avatar,
  HStack,
  IconButton,
  useDisclosure,
  useColorModeValue,
  Stack,
  Text,
} from '@chakra-ui/react';
import { HamburgerIcon, CloseIcon, InfoIcon } from '@chakra-ui/icons';
import logo from './../../Assets/logo_team1.png';
import { Link } from 'react-router-dom';
import { FaHome } from 'react-icons/fa';
import {BiPointer} from "react-icons/bi"; // Import the FaHome icon from react-icons/fa

export default function BetterNavbar() {
  const { isOpen, onOpen, onClose } = useDisclosure();

  const redirect = async ()=>{

    console.log("reload")
    await new Promise(resolve => setTimeout(resolve, 2000));
    window.location.reload();
  }

  return (
    <>
      <Box
        bg={useColorModeValue('white', 'gray.900')}
        px={4}
        borderBottom="1px solid"
        borderColor={useColorModeValue('gray.200', 'gray.700')}
      >
        <Flex h={16} alignItems="center" justifyContent="space-between">
          <IconButton
            bg="transparent"
            _hover={{
              bg: 'transparent',
            }}
            size="md"
            icon={isOpen ? <CloseIcon /> : <HamburgerIcon />}
            aria-label="Open Menu"
            display={{ md: 'none' }}
            onClick={isOpen ? onClose : onOpen}
          />
          <HStack spacing={8} alignItems="center">
            <Avatar size="sm" src={logo} w={10} h={10} />
            <HStack as="nav" spacing={4} display={{ base: 'none', md: 'flex' }}>
              <Link
                px={2}
                py={1}
                rounded="md"
                _hover={{ textDecoration: 'none' }}
                to="/"
              >
                <HStack>
                  <FaHome /> {/* Use the FaHome icon */}
                  <Link to="/" onClick={redirect} fontWeight="bold">Home</Link>
                </HStack>
              </Link>

              <Link
                  px={2}
                  py={1}
                  rounded="md"
                  _hover={{ textDecoration: 'none' }}
                  to="/"
              >
                <HStack>
                  <BiPointer /> {/* Use the FaHome icon */}
                  <Link to="/view/point" fontWeight="bold">View point</Link>
                </HStack>
              </Link>
              <Link
                px={2}
                py={1}
                rounded="md"
                _hover={{ textDecoration: 'none' }}
                to="/about"
              >
                <HStack>
                  <InfoIcon />
                  <Text fontWeight="bold">About</Text>
                </HStack>
              </Link>
            </HStack>
          </HStack>
        </Flex>

        {isOpen ? (
          <Box pb={4} display={{ md: 'none' }}>
            <Stack as="nav" spacing={4}>
              <Link
                px={2}
                py={1}
                rounded="md"
                _hover={{ textDecoration: 'none' }}
                to="/"
              >
                <HStack>
                  <FaHome /> {/* Use the FaHome icon */}
                  <Link to='/' fontWeight="bold">Home</Link>
                </HStack>
              </Link>
              <Link
                px={2}
                py={1}
                rounded="md"
                _hover={{ textDecoration: 'none' }}
                to="/about"
              >
                <HStack>
                  <InfoIcon />
                  <Text fontWeight="bold">About</Text>
                </HStack>
              </Link>
            </Stack>
          </Box>
        ) : null}
      </Box>
    </>
  );
}
